package cl.desafiolatam.desafiounobase

import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class HomeActivity : AppCompatActivity() {
    companion object {
        private const val base = "SP"
        const val user = base + "user"
	const val age = base + "age"
	const val nick = base + "nick"
	const val lang = base + "lang"
    }
    private lateinit var userName: String
    private lateinit var homeTitle: TextView
    private lateinit var nicknameTitle: TextView
    private lateinit var spanishCheckBox: CheckBox
    private lateinit var englishCheckBox: CheckBox
    private lateinit var germanCheckBox: CheckBox
    private lateinit var otherCheckBox: CheckBox
    private lateinit var otherTextInput: TextInputEditText
    private lateinit var nickNameInput: TextInputEditText
    private lateinit var ageInput: TextInputEditText
    private lateinit var save: Button
    private lateinit var container: ConstraintLayout
    private lateinit var sharedPreferences: SharedPreferences
// para almacenar los datos en shared preferences utilice claves que contengan el nombre del usuario y el nombre de el campo guardado.
    //esta recomendación no aplica para todos los valores, pero ayuda con varios
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
	val file = "cl.desafiolatam.sharedpreferences"
        sharedPreferences = getSharedPreferences(file, Context.MODE_PRIVATE)
        setUpViews()
        loadData()
        save.setOnClickListener {
            //Agregar los pasos necesario para guardar los datos
	    saveNickNameAndAge()
	    saveLanguages()
            Snackbar.make(container, "Datos guardados", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun setUpViews() {
        homeTitle = findViewById(R.id.home_title)
        nicknameTitle = findViewById(R.id.nickname_title)
        spanishCheckBox = findViewById(R.id.language_one)
        englishCheckBox = findViewById(R.id.language_two)
        germanCheckBox = findViewById(R.id.language_three)
        otherCheckBox = findViewById(R.id.language_other)
        otherTextInput = findViewById(R.id.other_language_input)
        nickNameInput = findViewById(R.id.nickname_input)
        ageInput = findViewById(R.id.age_input)
        save = findViewById(R.id.save_button)
        container = findViewById(R.id.container)
    }
    private fun loadData() {
        userName = sharedPreferences.getString(user, "UserName").toString()
        val title = "Bienvenido\nEsta es la pantalla inicial, aquí $userName podrá ver todas sus preferencias"
        homeTitle.text = title
        handleLanguages()
        loadProfile()
    }

    private fun loadProfile() {
        //crear las claves para buscar y almacenar los datos, recuerde asociar las mismas al usuario de alguna manera
        val nickNameString = sharedPreferences.getString(nick, "").toString()
        nickNameInput.setText(nickNameString)
        nicknameTitle.text = nickNameString
        val ageString = sharedPreferences.getInt(age, 0).toString()
        ageInput.setText(ageString)
    }

    private fun handleLanguages() {
        val langs = sharedPreferences.getString(lang, "").toString()
	var lista = langs.split("|")
	for (lang in lista) {
		if (lang.isNotEmpty()) {
			resolveLanguage(lang)
		}
	}
        //val languages = mutableSetOf()
        //ocupar resolveLanguage para cargar los datos iniciales en los checkboxs
    }

    private fun resolveLanguage(language: String) {
        if (language.isNotEmpty() && language == "Spanish") {
            spanishCheckBox.isChecked = true
        }
        if (language.isNotEmpty() && language == "English") {
            englishCheckBox.isChecked = true
        }
        if (language.isNotEmpty() && language == "German") {
            germanCheckBox.isChecked = true
        }
        if (language.isNotEmpty() && language.contains("Other")) {
            otherCheckBox.isChecked = true
            otherTextInput.setText(language.split("*")[1]) // ocupar el mismo delimitador para almacenar el valor de este campo
        }
    }

    private fun saveLanguages() {
        //crear lo necesario para guardar los idiomas seleccionados por el usuario
        //en sharedpreferences
	var langs: String = ""
	var del = "|"
        if (spanishCheckBox.isChecked) {
		langs = langs + "Spanish" + del
	}
	if (englishCheckBox.isChecked) {
		langs = langs + "English" + del
	}
	if (germanCheckBox.isChecked) {
		langs = langs + "German" + del
	}
	if (otherCheckBox.isChecked && otherTextInput.text!!.isNotEmpty()) {
		langs = langs + "Other" + "*" + otherTextInput.text.toString() + del
	}

	sharedPreferences.edit().putString(lang, langs).apply()

    }

    private fun saveNickNameAndAge() {
        if (nickNameInput.text!!.isNotEmpty()) {
           sharedPreferences.edit().putString(nick, nickNameInput.text.toString()).apply()
        }
        if (ageInput.text!!.isNotEmpty()) {
            val ageInt = ageInput.text.toString().toInt()
            sharedPreferences.edit().putInt(age, ageInt).apply()
        }
    }
}
