package com.opensource.boyd.talitome.database.data

import android.content.ContentValues
import android.content.Context
import android.content.res.Resources
import android.os.Parcel
import android.os.Parcelable
import com.opensource.boyd.talitome.R
import com.opensource.boyd.talitome.database.CharacterDatabaseContract.CharacterEntry

/**
 *
 * Created by Boyd on 8/28/2017.
 */
class data_characters(var context: Context) {

    var resources: Resources = context.resources

    data class character(
            var name: String,
            var expansion: String? = null,
            var strength: Int? = null,
            var craft: Int? = null,
            var life: Int? = null,
            var fate: Int? = null,
            var gold: Int? = null,
            var alignment: String? = null,
            var skills: List<String>? = null
    ) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readString(),
                parcel.createStringArrayList()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(name)
            parcel.writeString(expansion)
            parcel.writeValue(strength)
            parcel.writeValue(craft)
            parcel.writeValue(life)
            parcel.writeValue(fate)
            parcel.writeValue(gold)
            parcel.writeString(alignment)
            parcel.writeStringList(skills)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<character> {
            override fun createFromParcel(parcel: Parcel): character {
                return character(parcel)
            }

            override fun newArray(size: Int): Array<character?> {
                return arrayOfNulls(size)
            }
        }
    }

    var allCharacters = ArrayList<character>()

    private val WARRIOR = character(resources.getString(R.string.char_warrior_name),
            resources.getString(R.string.expansion_std),
            4, 2, 5, 1, 1,
            resources.getString(R.string.alignment_neutral),
            listOf(
                    resources.getString(R.string.char_warrior_skill_1),
                    resources.getString(R.string.char_warrior_skill_2))
    )
    private val GHOUL = character(resources.getString(R.string.char_ghoul_name),
            resources.getString(R.string.expansion_std),
            2, 4, 4, 4, 1,
            resources.getString(R.string.alignment_evil),
            listOf(
                    resources.getString(R.string.char_ghoul_skill_1),
                    resources.getString(R.string.char_ghoul_skill_2),
                    resources.getString(R.string.char_ghoul_skill_3))
    )

    private val WIZARD = character(resources.getString(R.string.char_wizard_name),
            resources.getString(R.string.expansion_std),
            2, 5, 4, 3, 1,
            resources.getString(R.string.alignment_evil),
            listOf(
                    resources.getString(R.string.char_wizard_skill_1),
                    resources.getString(R.string.char_wizard_skill_2),
                    resources.getString(R.string.char_wizard_skill_3))
    )

    private val ASSASSIN = character(resources.getString(R.string.char_assassin_name),
            resources.getString(R.string.expansion_std),
            3, 3, 4, 3, 1,
            resources.getString(R.string.alignment_evil),
            listOf(
                    resources.getString(R.string.char_assassin_skill_1),
                    resources.getString(R.string.char_assassin_skill_2)
            )
    )

    private val DRUID = character(resources.getString(R.string.char_druid_name),
            resources.getString(R.string.expansion_std),
            3, 3, 4, 3, 1,
            resources.getString(R.string.alignment_neutral),
            listOf(
                    resources.getString(R.string.char_druid_skill_1),
                    resources.getString(R.string.char_druid_skill_2),
                    resources.getString(R.string.char_druid_skill_3))
    )

    private val DWARF = character(resources.getString(R.string.char_dwarf_name),
            resources.getString(R.string.expansion_std),
            3, 3, 5, 5, 1,
            resources.getString(R.string.alignment_neutral),
            listOf(
                    resources.getString(R.string.char_dwarf_skill_1),
                    resources.getString(R.string.char_dwarf_skill_2),
                    resources.getString(R.string.char_dwarf_skill_3),
                    resources.getString(R.string.char_dwarf_skill_4),
                    resources.getString(R.string.char_dwarf_skill_5),
                    resources.getString(R.string.char_dwarf_skill_6))
    )

    private val ELF = character(resources.getString(R.string.char_elf_name),
            resources.getString(R.string.expansion_std),
            3, 4, 4, 3, 1,
            resources.getString(R.string.alignment_good),
            listOf(
                    resources.getString(R.string.char_elf_skill_1),
                    resources.getString(R.string.char_elf_skill_2),
                    resources.getString(R.string.char_elf_skill_3))
    )

    private val MINSTREL = character(resources.getString(R.string.char_minstrel_name),
            resources.getString(R.string.expansion_std),
            2, 4, 4, 5, 1,
            resources.getString(R.string.alignment_good),
            listOf(
                    resources.getString(R.string.char_minstrel_skill_1),
                    resources.getString(R.string.char_minstrel_skill_2),
                    resources.getString(R.string.char_minstrel_skill_3))
    )

    private val MONK = character(resources.getString(R.string.char_monk_name),
            resources.getString(R.string.expansion_std),
            2, 3, 4, 5, 1,
            resources.getString(R.string.alignment_good),
            listOf(
                    resources.getString(R.string.char_monk_skill_1),
                    resources.getString(R.string.char_monk_skill_2),
                    resources.getString(R.string.char_monk_skill_3))
    )

    private val PRIEST = character(resources.getString(R.string.char_priest_name),
            resources.getString(R.string.expansion_std),
            2, 4, 4, 5, 1,
            resources.getString(R.string.alignment_good),
            listOf(
                    resources.getString(R.string.char_priest_skill_1),
                    resources.getString(R.string.char_priest_skill_2),
                    resources.getString(R.string.char_priest_skill_3),
                    resources.getString(R.string.char_priest_skill_4))
    )

    private val PROPHETESS = character(resources.getString(R.string.char_prophetess_name),
            resources.getString(R.string.expansion_std),
            2, 4, 4, 2, 1,
            resources.getString(R.string.alignment_good),
            listOf(
                    resources.getString(R.string.char_prophetess_skill_1),
                    resources.getString(R.string.char_prophetess_skill_2),
                    resources.getString(R.string.char_prophetess_skill_3),
                    resources.getString(R.string.char_prophetess_skill_4))
    )

    private val SORCERESS = character(resources.getString(R.string.char_sorceress_name),
            resources.getString(R.string.expansion_std),
            2, 4, 4, 3, 1,
            resources.getString(R.string.alignment_evil),
            listOf(
                    resources.getString(R.string.char_sorceress_skill_1),
                    resources.getString(R.string.char_sorceress_skill_2),
                    resources.getString(R.string.char_sorceress_skill_3),
                    resources.getString(R.string.char_sorceress_skill_4))
    )

    private val THIEF = character(resources.getString(R.string.char_thief_name),
            resources.getString(R.string.expansion_std),
            3, 3, 4, 2, 1,
            resources.getString(R.string.alignment_neutral),
            listOf(
                    resources.getString(R.string.char_thief_skill_1),
                    resources.getString(R.string.char_thief_skill_2))
    )

    private val TROLL = character(resources.getString(R.string.char_troll_name),
            resources.getString(R.string.expansion_std),
            6, 1, 6, 1, 1,
            resources.getString(R.string.alignment_neutral),
            listOf(
                    resources.getString(R.string.char_troll_skill_1),
                    resources.getString(R.string.char_troll_skill_2))
    )

    init {
        allCharacters.add(WARRIOR)
        allCharacters.add(GHOUL)
        allCharacters.add(TROLL)
        allCharacters.add(THIEF)
        allCharacters.add(SORCERESS)
        allCharacters.add(PRIEST)
        allCharacters.add(PROPHETESS)
        allCharacters.add(MONK)
        allCharacters.add(MINSTREL)
        allCharacters.add(ELF)
        allCharacters.add(DWARF)
        allCharacters.add(DRUID)
        allCharacters.add(ASSASSIN)
        allCharacters.add(WIZARD)
    }

    fun createStandardCharacters() : List<character> {
        return allCharacters.filter { it.expansion == resources.getString(R.string.expansion_std) }
    }

}