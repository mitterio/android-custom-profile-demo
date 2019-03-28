package io.mitter.recipes

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import io.mitter.models.mardle.messaging.Message
import kotlinx.android.synthetic.main.item_message_other.view.*
import kotlinx.android.synthetic.main.item_message_self.view.*

class ChatRecyclerViewAdapter(
    private val messageList: List<Message>,
    private val currentUserId: String
) : RecyclerView.Adapter<ChatRecyclerViewAdapter.ViewHolder>() {
    private val MESSAGE_SELF_VIEW = 0
    private val MESSAGE_OTHER_VIEW = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutId = if (viewType == MESSAGE_SELF_VIEW) R.layout.item_message_self else R.layout.item_message_other
        val itemView = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = messageList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindMessage(messageList[position])
    }

    override fun getItemViewType(position: Int) = if (messageList[position].senderId.domainId() == currentUserId)
        MESSAGE_SELF_VIEW else MESSAGE_OTHER_VIEW

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindMessage(message: Message) {
            with(message) {
                if (senderId.domainId() == currentUserId) {
                    itemView?.selfMessageText?.text = textPayload
                } else {
                    itemView?.otherMessageText?.text = textPayload
                    Glide.with(itemView.context)
                        .load("https://static1.squarespace.com/static/53ed0e3ce4b0c296acaeae80/57f4d399440243d357b24ad7/5a4e04150d9297b75329123d/1515062399381/PLANTE-4058-Edit+Headshot+Photography+by+Tommy+Collier+Productions+Denver+Colorado+Headshots+Photographer.jpg?format=1500w")
                        .circleCrop()
                        .into(itemView.senderImage)
                }
            }
        }
    }
}
