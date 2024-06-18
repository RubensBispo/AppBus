import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import br.com.etecia.appbus.R;


public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail, edtSenha;
    private Button btnEntrar, btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        // Inicialização dos elementos da interface
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnSair = findViewById(R.id.btnSair);

        // Configuração do clique do botão de entrar
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUsuario(); // Chamando o método para fazer a requisição à API
            }
        });

        // Configuração do clique do botão de sair
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Fecha a atividade de login
            }
        });
    }

    private void getUsuario() {
        String email = edtEmail.getText().toString().trim();
        String senha = edtSenha.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            edtEmail.setError("Por favor entre com seu email");
            edtEmail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(senha)) {
            edtSenha.setError("Por favor entre com a senha");
            edtSenha.requestFocus();
            return;
        }

        // Exemplo usando PerformNetworkRequest (supondo que seja uma AsyncTask genérica)
        HashMap<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("senha", senha);

        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_GET_USUARIO, params, CODE_POST_REQUEST);
        request.execute();
    }

}
