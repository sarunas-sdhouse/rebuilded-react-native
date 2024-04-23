package lt.parkuok.googleauthexporeactnative

import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.modules.core.ActivityEventListener
import android.app.Activity
import android.content.Intent
import java.util.Locale
// KEVIN SDK
import eu.kevin.android.Kevin
import eu.kevin.android.KevinAccountsPlugin
import eu.kevin.android.KevinAccountsConfiguration
import eu.kevin.android.KevinPaymentsPlugin
import eu.kevin.android.KevinPaymentsConfiguration
import eu.kevin.android.AccountSessionConfiguration
import eu.kevin.android.KevinCountry
import eu.kevin.android.AccountSessionActivity
import eu.kevin.android.AccountSessionContract
import eu.kevin.android.SessionResult
import eu.kevin.android.AccountSessionResult
import eu.kevin.android.PaymentSessionConfiguration
import eu.kevin.android.PaymentType
import eu.kevin.android.PaymentSessionActivity
import eu.kevin.android.PaymentSessionContract
import eu.kevin.android.PaymentSessionResult

class KevinModule internal constructor(context: ReactApplicationContext?) :
    ReactContextBaseJavaModule(context) {

    init {
        context?.addActivityEventListener(this)
        
        // Setup your custom theme which extends Theme.Kevin.Base
        Kevin.setTheme(R.style.Theme_Kevin_Base)
        // Set optional locale, default is phone locale
        Kevin.setLocale(Locale("en"))
        // Initialize required plugins with your callback urls
        KevinAccountsPlugin.configure(
            KevinAccountsConfiguration.builder()
                .setCallbackUrl("https://parkuok-new-staging.vercel.app/api/checkout/payment-request/confirmation")
                .build()
        )
        KevinPaymentsPlugin.configure(
            KevinPaymentsConfiguration.builder()
                .setCallbackUrl("https://parkuok-new-staging.vercel.app/api/checkout/payment-request/confirmation")
                .build()
        )
    }
}