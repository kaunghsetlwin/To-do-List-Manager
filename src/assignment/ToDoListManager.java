package assignment;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ToDoListManager extends JFrame implements ActionListener {

	
	private JLabel taskLabel;
	private JTextField taskTextField;
	private JButton addTask,removeTask,clearAll;
	private JList <String> taskList;
	private DefaultListModel<String> listModel;
	
	public ToDoListManager() {
		initiliazeComponent();
		addUIComponent();
		this.setVisible(true);
	}
	
	

	private void addUIComponent() {
		
		JPanel taskPanel = new JPanel();
		taskPanel.add(taskLabel);
		taskPanel.add(taskTextField);
		taskPanel.add(addTask);
		this.add(taskPanel,BorderLayout.NORTH);
		
		JScrollPane scrollPane  = new JScrollPane(taskList);
		JPanel listPanel = new JPanel(new BorderLayout(5,5));
		listPanel.add(scrollPane);
		this.add(listPanel,BorderLayout.CENTER);
		
		JPanel btnPanel = new JPanel ();
		btnPanel.add(removeTask);
		btnPanel.add(clearAll);
		this.add(btnPanel,BorderLayout.SOUTH);
		
		
		
		
	}



	private void initiliazeComponent() {
		this.setTitle("To Do List Manager");
		this.setSize(500,500);
		this.setLayout(new BorderLayout(10,10));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.taskLabel = new JLabel ("Task :");
		this.taskTextField = new JTextField(15);
		
		
		this.addTask = new JButton("Add Task");
		this.removeTask = new JButton("Remove Task");
		this.clearAll = new JButton("Clear All");
		
		this.listModel = new DefaultListModel();
		this.taskList = new JList(listModel);
		
		addTask.addActionListener(this);
		removeTask.addActionListener(this);
		clearAll.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addTask) {
			String task = this.taskTextField.getText();
			if(!task.isEmpty()) {
				listModel.addElement(task);
				taskTextField.setText("");
			}else if (task.isEmpty()){
			   JOptionPane.showMessageDialog(this, "Please Enter In the Text Box");
			   }
		}else if (e.getSource() == removeTask) {
			int selectIndex = taskList.getSelectedIndex();
			if(selectIndex != -1) {
				listModel.remove(selectIndex);
			}
		}else if (e.getSource() == clearAll) {
			  listModel.clear();
		}
		
	}
	
	

}
