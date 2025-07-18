package org.scoula.board.service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.sound.midi.Soundbank;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.scoula.common.util.UploadFiles;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

	final private BoardMapper mapper;

	private final static String BASE_DIR = "/Users/hoonssac/Desktop";

	@Override
	public List<BoardDTO> getList() {
		log.info("getList.........");

		// VO -> DTO
		return mapper.getList().stream()
			.map(BoardDTO::of)
			.toList();
	}

	@Override
	public BoardDTO get(Long no) {
		log.info("get........" + no);
		System.out.println(mapper.get(no).getAttaches());
		BoardDTO board = BoardDTO.of(mapper.get(no));
		return Optional.ofNullable(board)
			.orElseThrow(NoSuchElementException::new);
	}

	// 2개 이상의 insert 문이 실행될 수 있으므로 트랜잭션 처리 필요
	// RuntimeException인 경우만 자동 rollback.
	@Transactional
	@Override
	public void create(BoardDTO board) {
		log.info("create....." + board);
		BoardVO boardVO = board.toVo();
		mapper.create(boardVO);

		// 파일 업로드 처리
		List<MultipartFile> files = board.getFiles();
		if (files != null && !files.isEmpty()) {
			upload(boardVO.getNo(), files);
			System.out.println("파일 업로드한다");
		}
	}

	@Override
	public boolean update(BoardDTO board) {
		log.info("update......" + board);
		return mapper.update(board.toVo()) == 1;
	}

	@Override
	public boolean delete(Long no) {
		log.info("delete......" + no);
		return mapper.delete(no) == 1;
	}

	public void upload(Long bno, List<MultipartFile> files) {
		for (MultipartFile part : files) {
			if (part.isEmpty()) {
				continue;
			}
			try {
				String uploadPath = UploadFiles.upload(BASE_DIR, part);
				BoardAttachmentVO attach = BoardAttachmentVO.of(part, bno, uploadPath);
				mapper.createAttachment(attach);
			} catch (IOException e) {
				throw new RuntimeException(e); // @Transactional 에서 감지, 자동 rollback
			}
		}
	}

	// 첨부파일 한 개 얻기
	@Override
	public BoardAttachmentVO getAttachment(Long no) {
		return mapper.getAttachment(no);
	}

	@Override
	public boolean deleteAttachment(Long no) {
		return mapper.deleteAttachment(no) == 1;
	}
}
