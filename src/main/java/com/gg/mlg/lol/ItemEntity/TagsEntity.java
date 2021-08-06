package com.gg.mlg.lol.ItemEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
public class TagsEntity {
//    private Map<String, String[]> tags = new HashMap<String, String[]>();
//    TagsEntity() {
//        tags.put("sss", value[0]);
//    }

//    private String name[]={"공격력", "치명타", "공속", "적중시 효과", "방관", "주문력", "마나 및 마나재생", "마관", "체력 및 체력재생", "방어력", "마저", "쿨감", "이속", "흡혈", "소모품"};
    private String value[][] = {
        {"Damage"},
        {"CriticalStrike"},
        {"AttackSpeed"},
        {"OnHit"},
        {"ArmorPenetration"},
        {"SpellDamage"},
        {"ManaRegen", "Mana"},
        {"MagicPenetration"},
        {"Health", "HealthRegen"},
        {"Armor"},
        {"SpellBlock"},
        {"CooldownReduction", "AbilityHaste"},
        {"boots", "NonbootsMovement", "Slow", "Tenacity"},
        {"LifeSteal", "SpellVamp"},
        {"Consumable"}};
}
