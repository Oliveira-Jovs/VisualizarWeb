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
            // Aqui você pode realizar mais ações, como redirecionar ou limpar o formulário
        })
        .catch(error => {
            console.error('Erro:', error);
        });
    });
});
