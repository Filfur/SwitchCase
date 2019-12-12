package com.artemglotov.switchcase.json

import com.artemglotov.switchcase.core.models.Case
import com.artemglotov.switchcase.core.models.Skin

fun List<CaseJson>.toCases(): List<Case> = this.map { it.toCase() }

fun CaseJson.toCase(): Case = Case(caseId, name, price, imageLink)

fun List<SkinJson>.toSkins(): List<Skin> = this.map { it.toSkin() }

fun SkinJson.toSkin(): Skin = Skin(skinId, name, price, weaponName, dropRate, caseId, imageLink, rarity)