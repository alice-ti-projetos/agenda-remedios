package com.example.gerenciamento_remedios

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AddMedDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = layoutInflater.inflate(R.layout.fragment_add_med_dialog, null)
        val nameInput = view.findViewById<EditText>(R.id.edt_med_name)
        val timeInput = view.findViewById<EditText>(R.id.edt_med_time)

        return MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.add_med_title)
            .setView(view)
            .setPositiveButton(R.string.save) { _, _ ->
                setFragmentResult(
                    REQUEST_KEY,
                    bundleOf(
                        "name" to nameInput.text.toString(),
                        "time" to timeInput.text.toString()
                    )
                )
            }
            .setNegativeButton(R.string.cancel, null)
            .create()
    }

    companion object {
        const val TAG = "AddMedDialog"
        const val REQUEST_KEY = "add_med_request"
    }
}