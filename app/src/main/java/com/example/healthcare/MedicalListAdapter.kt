package com.example.healthcare

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.healthcare.data.Medical
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class MedicalListAdapter(context: Context):
   RecyclerView.Adapter<MedicalListAdapter.MedicalViewHolder>() {

   private val inflater = LayoutInflater.from(context)
   private var medicals: List<Medical> = emptyList()

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicalViewHolder {

      val recyclerViewItem =
         inflater
            .inflate(R.layout.recycler_view_item, parent, false)

      return MedicalViewHolder(recyclerViewItem)
   }

   override fun getItemCount() = medicals.size

   override fun onBindViewHolder(holder: MedicalViewHolder, position: Int) {
      val medical = medicals[position]
      holder.codeTextView.text = medical.fname
      holder.titleTextView.text = medical.lname
      holder.hospitalTextView.text = medical.hospital
      holder.doctorNTextView.text = medical.doctor
      holder.cardNTextView.text = medical.card.toString()
      holder.checkTextView.text = medical.check

   }

   internal fun setMedicals(medicals: List<Medical>){
      this.medicals = medicals
      notifyDataSetChanged()
   }

   inner class MedicalViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
      val codeTextView = itemView.list_code_textview
      val titleTextView = itemView.list_title_textview
      val hospitalTextView = itemView.list_hospital_textview
      val doctorNTextView = itemView.list_doctor_textview
      val cardNTextView = itemView.list_card_textview
      val checkTextView = itemView.list_check_textview
   }
}


