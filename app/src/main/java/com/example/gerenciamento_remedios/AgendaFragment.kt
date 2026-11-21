package com.example.gerenciamento_remedios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AgendaFragment : Fragment(R.layout.fragment_agenda) {

    private val meds = mutableListOf<Pair<String, String>>() // name to time
    private lateinit var adapter: MedAdapter
    private lateinit var warning: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        warning = view.findViewById(R.id.txt_med_warn)
        val recycler = view.findViewById<RecyclerView>(R.id.rv_meds)

        adapter = MedAdapter(meds)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        // Listen for the result sent by the "add medication" dialog
        parentFragmentManager.setFragmentResultListener(
            AddMedDialogFragment.REQUEST_KEY, viewLifecycleOwner
        ) { _, bundle ->
            val name = bundle.getString("name").orEmpty()
            val time = bundle.getString("time").orEmpty()
            meds.add(name to time)
            adapter.notifyItemInserted(meds.size - 1)
            updateWarning()
        }

        updateWarning()
    }

    private fun updateWarning() {
        warning.visibility = if (meds.isEmpty()) View.VISIBLE else View.GONE
    }
}

// Minimal adapter using a built-in two-line layout
class MedAdapter(private val items: List<Pair<String, String>>) :
    RecyclerView.Adapter<MedAdapter.VH>() {

    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val title: TextView = v.findViewById(android.R.id.text1)
        val subtitle: TextView = v.findViewById(android.R.id.text2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
        LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_2, parent, false)
    )

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.title.text = items[position].first
        holder.subtitle.text = items[position].second
    }

    override fun getItemCount() = items.size
}