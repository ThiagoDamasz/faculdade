public class Computador {

    public String marca;
    public float preco;
    public HardwareBasico[] hardware = new HardwareBasico[3];
    public SistemaOperacional sistema;
    public MemoriaUSB musb;

    public Computador() {
        this.hardware[0] = new HardwareBasico();
        this.hardware[1] = new HardwareBasico();
        this.hardware[2] = new HardwareBasico();
        this.sistema = new SistemaOperacional();
    }

    public void addMemoriaUSB(MemoriaUSB musb) {
        this.musb = musb;
    }

    public void mostrarPCConfigs() {
        System.out.println("========================================");
        System.out.println("            CONFIGURAÇÃO DO PC          ");
        System.out.println("========================================");
        System.out.println("🏷️  Marca: " + marca);  // PEDI PRO CHAT BOTAR OS ÍCones e deixar mais bonito
        System.out.println("----------------------------------------");
        System.out.println("💾 HARDWARE:");

        for (int i = 0; i < hardware.length; i++) {
            System.out.println("🔹 Nome: " + hardware[i].getNome()); // erro, tive de mudar por conta do encapsulamento
            System.out.println("🔹 Capacidade: " + hardware[i].getCapacidade() + " GB");
        }

        System.out.println("----------------------------------------");
        System.out.println("🖥️ SISTEMA OPERACIONAL:");
        System.out.println("🔹 Nome: " + sistema.getNome()); // aqui deve ser get
        System.out.println("🔹 Arquitetura: " + sistema.getTipo() + " bits");

        if (musb != null) {
            System.out.println("----------------------------------------");
            System.out.println("📀 MEMÓRIA EXTERNA:");
            System.out.println("🔹 Nome: " + musb.getNome()); // aqui também tem que chamar o get
            System.out.println("🔹 Capacidade: " + musb.getCapacidade() + " GB");
        }

        System.out.println("========================================");
    }
}
