using Avalonia.Controls;
using Avalonia.Interactivity;
using Avalonia.Markup.Xaml;

namespace AudiobasicsDesk.Views;

public partial class PairingView : UserControl
{
    public PairingView() => AvaloniaXamlLoader.Load(this);

    private void OnConnectClicked(object? sender, RoutedEventArgs e)
    {
        var code = CodeInput.Text?.Trim() ?? "";

        if (code.Length != 6)
        {
            StatusText.Text = "Please enter a valid 6-digit code";
            return;
        }

        // TODO: initiate mDNS discovery + socket connection with pairing code
        StatusText.Text = "Connecting...";
        ConnectButton.IsEnabled = false;
    }
}
