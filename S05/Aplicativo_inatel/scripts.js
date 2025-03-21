function openMenu() {
    document.getElementById("menu").style.display = "block"
}

function closeMenu() {
    document.getElementById("menu").style.display = "none"
}

function temaEscuro() {
    document.documentElement.style.setProperty('--cor-icone', '#4E20A2')
    document.documentElement.style.setProperty('--cor-back1', '#162133')
    document.documentElement.style.setProperty('--cor-texto', 'white')
    document.documentElement.style.setProperty('--cor-sombra', '#D9C5A0')

}

function temaClaro() {
    document.documentElement.style.setProperty('--cor-icone', '#4970BF')
    document.documentElement.style.setProperty('--cor-back1', '#FAFCFB')
    document.documentElement.style.setProperty('--cor-texto', 'black')
    document.documentElement.style.setProperty('--cor-sombra', 'black')
}

const eventos = [
    {
        id: 1,
        title: 'Semana do Software 2025',
        date: '12/05',
        time: '10:00',
        location: 'Salão de Eventos',
        type: 'tech',
        description: 'Uma semana inteira dedicada à tecnologia e inovação, com palestras, workshops e hackathons.',
        image: 'https://images.unsplash.com/photo-1504384308090-c894fdcc538d?auto=format&fit=crop&q=80&w=800&h=400'
    },
    {
        id: 2,
        title: 'Workshop de IoT',
        date: '12/01',
        time: '08:00',
        location: 'Laboratório CS&I',
        type: 'tech',
        description: 'Workshop prático sobre Internet das Coisas e suas aplicações na indústria 4.0.',
        image: 'https://images.unsplash.com/photo-1518770660439-4636190af475?auto=format&fit=crop&q=80&w=800&h=400'
    },
    {
        id: 3,
        title: 'Festa dos Alunos 2025',
        date: '18/05',
        time: '19:00',
        location: 'Área Esportiva do Inatel',
        type: 'cultural',
        description: 'Venha comemorar a melhor Festa dos Alunos de todos os tempos!',
        image: 'https://images.unsplash.com/photo-1514525253161-7a46d19cd819?auto=format&fit=crop&q=80&w=800&h=400'
    },
    {
        id: 4,
        title: 'Feira de Oportunidades',
        date: '04/05',
        time: '10:00',
        location: 'Salão de Eventos',
        type: 'academic',
        description: 'Venha conhecer empresas e projetos com destaque na área da engenharia.',
        image: 'https://images.unsplash.com/photo-1517245386807-bb43f82c33c4?auto=format&fit=crop&q=80&w=800&h=400'
    }
];

document.addEventListener("DOMContentLoaded", function () {
    const carousel = document.querySelector('.carousel');

    function createCards() {
        if (!carousel) {
            console.error("Elemento .carousel não encontrado!");
            return;
        }

        eventos.forEach(event => {
            const card = document.createElement('div');
            card.classList.add('card');
            card.innerHTML = `
                <img src="${event.image}" alt="${event.title}">
                <div class="info">
                    <h3>${event.title}</h3>
                    <p>${event.description}</p>
                    <p><span class="material-symbols-outlined icon">event</span> ${event.date} às ${event.time} 
                    <span class="material-symbols-outlined icon">pin_drop</span> ${event.location}</p>
                </div>
            `;
            carousel.appendChild(card);
        });
    }

    // Controle do carrossel
    let index = 0;
    function nextCard() {
        index = (index + 1) % eventos.length;
        updateCarousel();
    }

    function prevCard() {
        index = (index - 1 + eventos.length) % eventos.length;
        updateCarousel();
    }

    function updateCarousel() {
        carousel.style.transform = `translateX(-${index * 100}%)`;
    }

    // Adicionando interatividade
    document.getElementById('nextBtn').addEventListener('click', nextCard);
    document.getElementById('prevBtn').addEventListener('click', prevCard);

    // Arrastar no celular
    let startX;
    carousel.addEventListener('touchstart', (e) => {
        startX = e.touches[0].clientX;
    });
    carousel.addEventListener('touchend', (e) => {
        let endX = e.changedTouches[0].clientX;
        if (startX - endX > 50) nextCard();
        if (endX - startX > 50) prevCard();
    });

    let autoSlide = setInterval(nextCard, 5000);

    carousel.addEventListener("mouseover", () => {
        clearInterval(autoSlide);
    });

    carousel.addEventListener("mouseout", () => {
        autoSlide = setInterval(nextCard, 5000);
    });

    createCards();
});
