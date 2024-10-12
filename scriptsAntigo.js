document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('form-evento').addEventListener('submit', function(event) {
        event.preventDefault();

        // Crie o objeto evento
        const evento = {
            nome: document.getElementById('nome').value,
            descricao: document.getElementById('descricao').value,
            data: document.getElementById('data').value,
            local: document.getElementById('local').value,
        };

        // Primeiro POST: Criar o Evento
        fetch('http://localhost:8080/evento', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(evento)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao cadastrar evento: ' + response.statusText);
            }
            return response.json(); // Retorna o objeto Evento com o ID
        })
        .then(data => {
            console.log('Evento cadastrado com sucesso:', data);
            // Feedback de sucesso
            document.getElementById('mensagem').innerHTML = `<p style="color: green;">Evento cadastrado com sucesso!</p>`;
            // Aqui você pode redirecionar ou limpar o formulário
            document.getElementById('form-evento').reset();
        })
        .catch(error => {
            console.error('Erro:', error);
            // Feedback de erro
            document.getElementById('mensagem').innerHTML = `<p style="color: red;">Erro ao cadastrar evento: ${error.message}</p>`;
        });
    });
});
