package com.project.egloo.recipe.domain;

import com.project.egloo.common.ColumnDescription;
import com.project.egloo.ingredient.domain.Ingredient;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cooking {

    @Id
    @GeneratedValue
    @Column(name = "cooking_id")
    @ColumnDescription("PK")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    @ColumnDescription("FK 레시피 ID")
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    @ColumnDescription("FK 재료 ID")
    private Ingredient ingredient;

    @ColumnDescription("수량")
    private int quantity;

    @Enumerated(EnumType.STRING)
    @ColumnDescription("단위")
    private Unit unit;

    @ColumnDescription("가격")
    private int price;

    @Column(name = "is_necessary")
    @ColumnDescription("필수 여부")
    private boolean isNecessary;
}
