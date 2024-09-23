document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('form-servidor').addEventListener('submit', function(event) {
        event.preventDefault();

        // Primeiro, crie o objeto endereço
        const endereco = {
            estado: document.getElementById('estado').value,
            cidade: document.getElementById('cidade').value,
            cep: document.getElementById('cep').value,
            bairro: document.getElementById('bairro').value,
            rua: document.getElementById('rua').value,
            numero: document.getElementById('numero').value,
            complemento: document.getElementById('complemento').value
        };

        // Primeiro POST: Criar o Endereço
        fetch('http://localhost:8080/endereco', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(endereco)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao cadastrar endereço: ' + response.statusText);
            }
            return response.json(); // Retorna o objeto Endereço com o ID
        })
        .then(enderecoCriado => {
            // Pega o ID do endereço criado
            const enderecoId = enderecoCriado.id;

            // Agora crie o objeto servidor, incluindo o ID do endereço
            const servidor = {
                saepe: document.getElementById('saepe').value,
                nome: document.getElementById('nome').value,
                CPF: document.getElementById('cpf').value,
                RG: document.getElementById('rg').value,
                dataNascimento: document.getElementById('dataNascimento').value,
                telefone: document.getElementById('telefone').value,
                email: document.getElementById('email').value,
                idEndereco: enderecoId // Inclui o ID do endereço
            };

            // Segundo POST: Criar o Servidor
            return fetch('http://localhost:8080/servidores', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(servidor)
            });
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao cadastrar servidor: ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            alert('Servidor cadastrado com sucesso!');
            console.log('Success:', data);
        })
        .catch(error => {
            console.error('Erro ao cadastrar servidor ou endereço:', error);
        });
    });
});

document.addEventListener('DOMContentLoaded', function() {
   document.getElementById('form-alunos').addEventListener('submit', function(event) {
            event.preventDefault()
        
     
        const endereco = {
            estado: document.getElementById('estado').value,
            cidade: document.getElementById('cidade').value,
            cep: document.getElementById('cep').value,
            bairro: document.getElementById('bairro').value,
            rua: document.getElementById('rua').value,
            numero: document.getElementById('numero').value,
            complemento: document.getElementById('complemento').value
        };

        // Primeiro POST: Criar o Endereço
        fetch('http://localhost:8080/endereco', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(endereco)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao cadastrar endereço: ' + response.statusText);
            }
            return response.json(); // Retorna o objeto Endereço com o ID
        })
        .then(enderecoCriado => {
            // Pega o ID do endereço criado
            const enderecoId = enderecoCriado.id;

            const alunos = {
            
                nome: document.getElementById('nome').value,
                CPF: document.getElementById('cpf').value,
                RG: document.getElementById('rg').value,
                dataNascimento: document.getElementById('dataNascimento').value,
                telefone: document.getElementById('telefone').value,
                email: document.getElementById('email').value,
                idEndereco: enderecoId // Inclui o ID do endereço
            };
       
            // Segundo POST: Criar o ALUNOS
            return fetch('http://localhost:8080/alunos', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(alunos)
            });
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao cadastrar alunos: ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            alert('Alunos cadastrado com sucesso!');
            console.log('Success:', data);
        })
        .catch(error => {
            console.error('Erro ao cadastrar aluno ou endereço:', error);
        });
    });
});