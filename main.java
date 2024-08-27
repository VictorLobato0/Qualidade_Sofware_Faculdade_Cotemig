
    class Program
    {
        static void Main(string[] args)
        {
            bool sair = false;

            while (!sair)
            {
                Console.WriteLine("Menu:");
                Console.WriteLine("1 - Calcular Fatorial");
                Console.WriteLine("2 - Calcular Soma dos N primeiros elementos da Série de Fibonacci");
                Console.WriteLine("0 - Sair");
                Console.Write("Escolha uma opção: ");
                
                string opcao = Console.ReadLine();

                switch (opcao)
                {
                    case "1":
                        CalcularFatorial();
                        break;
                    case "2":
                        CalcularSomaFibonacci();
                        break;
                    case "0":
                        sair = true;
                        Console.WriteLine("Saindo...");
                        break;
                    default:
                        Console.WriteLine("Opção inválida! Tente novamente.");
                        break;
                }

                Console.WriteLine();
            }
        }

        static void CalcularFatorial()
        {
            Console.Write("Digite um número para calcular o fatorial: ");
            int n = int.Parse(Console.ReadLine());

            Math math = new Math();
            try
            {
                int resultado = math.Fatorial(n);
                Console.WriteLine($"Fatorial de {n} é: {resultado}");
            }
            catch (ArgumentException ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        static void CalcularSomaFibonacci()
        {
            Console.Write("Digite um número para calcular a soma da Série de Fibonacci: ");
            int n = int.Parse(Console.ReadLine());

            Fibonacci fibonacci = new Fibonacci();
            try
            {
                int resultado = fibonacci.SomaFibonacci(n);
                Console.WriteLine($"A soma dos primeiros {n} números da Série de Fibonacci é: {resultado}");
            }
            catch (ArgumentException ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        // Classe para cálculo do fatorial
        public class Math
        {
            public int Fatorial(int n)
            {
                if (n < 0)
                    throw new ArgumentException("O número deve ser não-negativo.");

                int fat = 1;
                for (int i = 1; i <= n; i++)
                {
                    fat *= i;
                }
                return fat;
            }
        }

        // Classe para cálculo da soma da Série de Fibonacci
        public class Fibonacci
        {
            public int SomaFibonacci(int n)
            {
                if (n < 0)
                    throw new ArgumentException("O número deve ser não-negativo.");
                if (n == 0)
                    return 0;
                if (n == 1)
                    return 1;

                int a = 0, b = 1, soma = 1;
                for (int i = 2; i < n; i++)
                {
                    int temp = a + b;
                    a = b;
                    b = temp;
                    soma += b;
                }
                return soma;
            }
        }

        [TestFixture] // Classe de teste para Fibonacci
        public class FibonacciTest
        {
            [Test] 
            public void TestSomaFibonacci()
            {
                Fibonacci fib = new Fibonacci();
                Assert.AreEqual(0, fib.SomaFibonacci(0));
                Assert.AreEqual(1, fib.SomaFibonacci(1));
                Assert.AreEqual(2, fib.SomaFibonacci(2));
                Assert.AreEqual(4, fib.SomaFibonacci(3));
                Assert.AreEqual(7, fib.SomaFibonacci(4));
                Assert.AreEqual(12, fib.SomaFibonacci(5));
            }
        }

        [TestFixture] // Classe de teste para Fatorial
        public class MathTest
        {
            [Test]
            public void TestFatorial()
            {
                Math m = new Math();
                Assert.AreEqual(1, m.Fatorial(0));
                Assert.AreEqual(1, m.Fatorial(1));
                Assert.AreEqual(2, m.Fatorial(2));
                Assert.AreEqual(6, m.Fatorial(3));
            }
        }
    }

