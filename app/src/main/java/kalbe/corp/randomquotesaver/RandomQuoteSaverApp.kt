package kalbe.corp.randomquotesaver

import android.app.Application
import kalbe.corp.randomquotesaver.data.Graph

class RandomQuoteSaverApp: Application(){
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}