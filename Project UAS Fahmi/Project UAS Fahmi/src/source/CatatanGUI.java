package source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CatatanGUI {
    private JFrame frame;
    private DefaultListModel<Catatan> listModel;
    private JList<Catatan> catatanList;

    public CatatanGUI() {
        frame = new JFrame("Aplikasi Catatan");
        listModel = new DefaultListModel<>();
        catatanList = new JList<>(listModel);
    }

    public void tampilkanGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add(new JScrollPane(catatanList), BorderLayout.CENTER);

        JButton tambahButton = new JButton("Tambah");
        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahCatatan();
            }
        });

        JButton hapusButton = new JButton("Hapus");
        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hapusCatatan();
            }
        });

        panel.add(tambahButton, BorderLayout.PAGE_START);
        panel.add(hapusButton, BorderLayout.PAGE_END);

        frame.getContentPane().add(panel);

        muatCatatanDariFile();

        frame.setVisible(true);
    }

    private void muatCatatanDariFile() {
        List<Catatan> catatanList = DataHandler.bacaCatatan();
        listModel.addAll(catatanList);
    }

    private void tambahCatatan() {
        String judul = JOptionPane.showInputDialog(frame, "Masukkan judul catatan:");
        String isi = JOptionPane.showInputDialog(frame, "Masukkan isi catatan:");

        Catatan catatan = new Catatan(isi, judul);

        listModel.addElement(catatan);

        simpanCatatanKeFile();
    }

    private void hapusCatatan() {
        int selectedIndex = catatanList.getSelectedIndex();
        if (selectedIndex != -1) {
            listModel.remove(selectedIndex);
            simpanCatatanKeFile();
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih catatan yang akan dihapus.");
        }
    }

    private void simpanCatatanKeFile() {
    List<Catatan> catatanList = new ArrayList<>();
    for (int i = 0; i < listModel.getSize(); i++) {
        catatanList.add((Catatan) listModel.getElementAt(i));
    }
    DataHandler.tulisCatatan(catatanList);
    }
}
