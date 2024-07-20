package com.example.contactapp

class DataSource {
        fun getContact():List<Contact>{
            val contacts = mutableListOf<Contact>()

            contacts.add(Contact(
                R.string.uncle_Ahmed,
                R.string.Num_uncle_Ahmed,
                R.drawable.uncleahmed
            ))
            contacts.add(Contact(
                R.string.fares,
                R.string.Nun_fares,
                R.drawable.fares
            ))
            contacts.add(Contact(
                R.string.tamer,
                R.string.Nun_tamer,
                R.drawable.tamerelgayar
            ))
            contacts.add(Contact(
                R.string.nasser,
                R.string.Nun_nasser,
                R.drawable.lastnasser
            ))
            contacts.add(Contact(
                R.string.refai,
                R.string.Nun_refai,
                R.drawable.refai
            ))
            contacts.add(Contact(
                R.string.gaafar,
                R.string.Num_gaafar,
                R.drawable.gaafaaar
            ))
            contacts.add(Contact(
                R.string.shwaha,
                R.string.Nun_shwaha,
                R.drawable.shwaha
            ))
            contacts.add(Contact(
                R.string.adel,
                R.string.Nun_adel,
                R.drawable.adelshakaltwo
            ))
            contacts.add(Contact(
                R.string.mohamed,
                R.string.Nun_mohamed,
                R.drawable.mohamedr
            ))
            contacts.add(Contact(
                R.string.amr,
                R.string.Nun_amr,
                R.drawable.amrbela
            ))
            contacts.add(Contact(
                R.string.Mbappe,
                R.string.Nun_Mbappe,
                R.drawable.mbappe
            ))

            return contacts
        }
    }
