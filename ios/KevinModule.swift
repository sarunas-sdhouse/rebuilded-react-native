import SwiftUI
import Kevin

@objc(KevinModule)
class KevinModule: NSObject {
    
  override init() {
    super.init()
    
    // Setup your custom theme which extends KevinTheme
    Kevin.shared.theme = KevinTheme()
    // Set optional locale, default is English locale
    Kevin.shared.locale = Locale(identifier: "en")
    // Initialize required plugins with your callback urls
    KevinAccountsPlugin.shared.configure(
      KevinAccountsConfiguration.Builder(
        callbackUrl: URL(string: "https://parkuok-new-staging.vercel.app/api/checkout/payment-request/confirmation")!
      ).build()
    )
    KevinInAppPaymentsPlugin.shared.configure(
      KevinInAppPaymentsConfiguration.Builder(
        callbackUrl: URL(string: "https://parkuok-new-staging.vercel.app/api/checkout/payment-request/confirmation")!
      ).build()
    )
  }
}