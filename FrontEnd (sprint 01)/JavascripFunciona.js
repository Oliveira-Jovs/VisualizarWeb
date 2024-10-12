// Função para obter eventos
async function getEventos() {
    try {
        const response = await fetch('http://localhost:8080/eventos'); // URL do seu backend
        if (!response.ok) {
            throw new Error(`Erro ao buscar eventos: ${response.status}`);
        }
        const eventos = await response.json(); // Parse do JSON retornado
        return eventos; // Retorna a lista de eventos
    } catch (error) {
        console.error(error); // Log de erros
        return []; // Retorna um array vazio em caso de erro
    }
}

// Função para exibir eventos na página
function exibirEventos(eventos) {
    const eventsContainer = document.querySelector('.events-container');
    eventsContainer.innerHTML = ''; // Limpa a lista existente

    if (eventos.length === 0) {
        eventsContainer.innerHTML = '<p>Nenhum evento encontrado.</p>';
        return;
    }

    eventos.forEach(evento => {
        const eventCard = document.createElement('div');
        eventCard.classList.add('event-card');
        eventCard.innerHTML = `
            <h3>${evento.nome}</h3>
            <div class="event-details">
                <p>Descrição: ${evento.descricao}</p>
                <p>Data: ${evento.data}</p>
                <p>Local: ${evento.local}</p>
                <p>Tipo: ${evento.tipo}</p>
            </div>
            <button onclick="deletarEvento(${evento.id})" class="btn">Deletar Evento</button>
        `;
        eventsContainer.appendChild(eventCard);
    });
}

// Função para deletar um evento
async function deletarEvento(idEvento) {
    const confirmacao = confirm('Você tem certeza que deseja deletar este evento?');

    if (!confirmacao) {
        return; // Se o usuário cancelar, não faz nada
    }

    try {
        const response = await fetch(`http://localhost:8080/eventos/${idEvento}`, {
            method: 'DELETE'
        });
        if (response.ok) {
            alert('Evento deletado com sucesso!');
            getEventos(); // Recarrega os eventos após exclusão
        } else {
            alert('Erro ao deletar evento');
        }
    } catch (error) {
        console.error('Erro ao deletar evento:', error);
    }
}

// Chamada da função e manipulação da resposta
getEventos().then(eventos => {
    exibirEventos(eventos); // Exibe os eventos na página
});
