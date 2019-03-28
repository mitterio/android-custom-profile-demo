package io.mitter.recipes

import android.app.Application
import io.mitter.android.Mitter
import io.mitter.android.domain.model.MitterConfig
import io.mitter.android.domain.model.UserAuth
import io.mitter.models.mardle.messaging.*
import org.greenrobot.eventbus.EventBus

class App : Application() {
    lateinit var mitter: Mitter

    override fun onCreate() {
        super.onCreate()

        val mitterConfig = MitterConfig(
            applicationId = "Izr37-Vm7TS-U8cIu-sVtqj"
        )

        val userAuth = UserAuth(
            userId = "XQQ8U-7JuFc-tPLON-AdGMl",
            userAuthToken = "eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJtaXR0ZXItaW8iLCJ1c2VyVG9rZW5JZCI6Ikt4anNsQ0tpazdWNmFuZ2YiLCJ1c2VydG9rZW4iOiI3ajMyNzg3a2I0NHJjcGtjdGFqMWxjdTFjZyIsImFwcGxpY2F0aW9uSWQiOiJJenIzNy1WbTdUUy1VOGNJdS1zVnRxaiIsInVzZXJJZCI6IlhRUThVLTdKdUZjLXRQTE9OLUFkR01sIn0.BWRK_QbvgdE3xfJtken4XEEtXUGaece85i-GRcQ88xNmbjlFB9zI-amTC5fR1i8w-_WXT0V__328SJeVDoWcNg"
        )

        val userAuth2 = UserAuth(
            userId = "VMCDv-czm5Z-nMDOJ-jJ67Y",
            userAuthToken = "eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJtaXR0ZXItaW8iLCJ1c2VyVG9rZW5JZCI6Ik5FMGg2OTJTM2FqMDRRQ3EiLCJ1c2VydG9rZW4iOiI5aWZmaWFpZjU2cGdrbnFxOXBmcjZlYnRhdSIsImFwcGxpY2F0aW9uSWQiOiJJenIzNy1WbTdUUy1VOGNJdS1zVnRxaiIsInVzZXJJZCI6IlZNQ0R2LWN6bTVaLW5NRE9KLWpKNjdZIn0.iAa8qbcra2WWtd-EoeddZfQKQAVgO1XSKP4_sYY4zjKLEPwjWtMY0uKbWgCiFDv-QWQx6VbOUWA2UxKz8DKAmw"
        )

        mitter = Mitter(
            context = this,
            mitterConfig = mitterConfig,
            userAuth = userAuth
        )

        mitter.registerOnPushMessageReceivedListener(object : Mitter.OnPushMessageReceivedCallback {
            override fun onChannelStreamData(channelId: String, streamId: String, streamData: ContextFreeMessage) {

            }

            override fun onNewChannel(channel: Channel) {

            }

            override fun onNewChannelTimelineEvent(channelId: String, timelineEvent: TimelineEvent) {

            }

            override fun onNewMessage(channelId: String, message: Message) {
                EventBus.getDefault().post(message)
            }

            override fun onNewMessageTimelineEvent(messageId: String, timelineEvent: TimelineEvent) {

            }

            override fun onParticipationChangedEvent(
                channelId: String,
                participantId: String,
                newStatus: ParticipationStatus,
                oldStatus: ParticipationStatus?
            ) {

            }

            override fun onTypingIndication(channelId: String, senderId: String) {
                if (mitter.getUserId() != senderId) {
                    EventBus.getDefault().post(TypingIndicator())
                }
            }
        })
    }
}
