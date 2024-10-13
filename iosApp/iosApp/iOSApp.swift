import SwiftUI
import composeApp

@main
struct iOSApp: App {

init() {
        KoinInitialiser.doInitKoin()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}