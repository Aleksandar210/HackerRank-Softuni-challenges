using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace MatchingGame
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            SetUpGame();
        }

        private void SetUpGame()
        {

            Random rand = new Random();
            List<string> currentEmojis = new List<string>()
            {
                "😂","😂",
                "🐱‍","🐱‍",
                "😍","😍",
                "😉","😉",
                "🐱‍🚀","🐱‍🚀",
                "✨","✨",
                "🎂","🎂",
                "🎡","🎡"
            };

            foreach(var currentTextBlock in MainGrid.Children.OfType<TextBlock>())
            {
                int getEmojiIndex = rand.Next(currentEmojis.Count);
                currentTextBlock.Text = currentEmojis[getEmojiIndex];
                currentEmojis.RemoveAt(getEmojiIndex);
            }
        }
    }
}
