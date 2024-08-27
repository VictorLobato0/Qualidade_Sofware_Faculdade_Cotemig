using System;
using NUnit.Framework; // Adicione esta importação para usar asserções de teste

namespace blastoisenite
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Código principal pode ir aqui
        }

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

        
        public class MathTest
        {
            
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
}
