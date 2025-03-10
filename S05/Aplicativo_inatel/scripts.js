function openMenu(){
    document.getElementById("menu").style.display = "block"
}

function closeMenu(){
    document.getElementById("menu").style.display = "none"
}

function temaEscuro(){
    document.documentElement.style.setProperty('--cor-icone', '#4E20A2')
    document.documentElement.style.setProperty('--cor-back1', '#162133')
    document.documentElement.style.setProperty('--cor-texto', 'white')
    document.documentElement.style.setProperty('--cor-sombra', '#D9C5A0')
   
}

function temaClaro(){
    document.documentElement.style.setProperty('--cor-icone', '#4970BF')
    document.documentElement.style.setProperty('--cor-back1', '#FAFCFB')
    document.documentElement.style.setProperty('--cor-texto', 'black')
    document.documentElement.style.setProperty('--cor-sombra', 'black')
}