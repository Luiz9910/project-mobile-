package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var persons: ArrayList<Person>
    private lateinit var adapter: PersonRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpList()
        setUpAddNewListElment()
    }

    /**
     * define o que deve acontecer quando o usuário clicar no botõo add person
     */
    private fun setUpAddNewListElment() {
        binding.btnAddPerson.setOnClickListener {
            val result = verifyFields()
            if (result.error.not()) {
                binding.editTextPersonName.setText("")
                binding.editTextPersonPhone.setText("")
                addNewElementOnList(result.person)
            }
        }
    }

    /**
     * notifica o adapter que o dataset da lista mudou.
     */
    private fun addNewElementOnList(person: Person) {
        persons.add(person)
        adapter.notifyItemChanged(persons.size - 1)
    }

    /**
     * validação dos campos nome e phone number
     */
    private fun verifyFields(): PersonOrError {
        var error = false
        var name = ""
        var phone = ""
        binding.editTextPersonName.text.toString().takeIf {
            it.isNotEmpty()
        }?.let {
            name = it
        } ?: kotlin.run {
            error = true
            binding.editTextPersonName.error = getString(R.string.name_error)
        }

        binding.editTextPersonPhone.text.toString().takeIf {
            it.isNotEmpty()
        }?.let {
            phone = it
        } ?: kotlin.run {
            error = true
            binding.editTextPersonPhone.error = getString(R.string.phone_error)
        }
        return PersonOrError(
            error,
            Person(
                name,
                phone
            )
        )
    }

    /**
     * Configuração inicial da lista
     */
    private fun setUpList() {
        persons = createInitialDataSet()
        adapter = PersonRecyclerViewAdapter(
            persons
        )
        val gridLayoutManager = GridLayoutManager(
            this,
            2
        )
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int = if (position % 3 == 0) 2 else 1
        }
        binding.listViewPersons.layoutManager = gridLayoutManager
        binding.listViewPersons.adapter = adapter
    }


    /**
     * Criação de um dataset inicial para a lista comçar carregada.
     */
    private fun createInitialDataSet(): ArrayList<Person> = arrayListOf(
        Person("Ana", "1111-1111", "Jogar Xadrez", 1.80, 100.0),
        Person("Bianca", "2222-2222"),
        Person("Carla", "3333-3333"),
        Person("Daniel", "4444-4444"),
        Person("Elaine", "5555-5555"),
        Person("Fernando", "6666-6666"),
        Person("Gabriela", "7777-7777"),
        Person("Henrique", "8888-8888"),
        Person("Isabela", "9999-9999"),
        Person("João", "1010-1010"),
        Person("Kátia", "1112-1112"),
        Person("Lucas", "1212-1212"),
        Person("Maria", "1313-1313"),
        Person("Natalia", "1414-1414"),
        Person("Oliver", "1515-1515"),
        Person("Paula", "1616-1616"),
        Person("Quiteria", "1717-1717"),
        Person("Ricardo", "1818-1818"),
        Person("Sabrina", "1919-1919"),
        Person("Thiago", "2020-2020")
    )

    data class PersonOrError(
        val error: Boolean,
        val person: Person
    )
}