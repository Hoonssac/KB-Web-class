package ch17.practice.p02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GiftItem {
     private String name;
     private String category;
     private int price;
     private int preferenceScore;
     private boolean forMom;
     private boolean forDad;
}
