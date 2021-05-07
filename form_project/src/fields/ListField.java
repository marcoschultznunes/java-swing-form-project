package fields;

import java.awt.Dimension;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import sizes.Sizes;

public class ListField extends FormField{
	private static final long serialVersionUID = -5306821779266432988L;
	
	private JList<String> list = new JList<String>();
	
	public ListField(String fieldName, List<String> items, Integer selectionMode) {
		super(fieldName);
		this.spanY = 2;
		
		DefaultListModel<String> lm = new DefaultListModel<String>();
		lm.addAll(items);
		list.setModel(lm);
		list.setSelectionMode(selectionMode);
		
		JScrollPane scrollList = new JScrollPane(list);
		scrollList.setPreferredSize(new Dimension(Sizes.DEFAULT_MAX_WIDTH, Sizes.DEFAULT_MAX_HEIGHT * 4));
		scrollList.setMinimumSize(new Dimension(Sizes.DEFAULT_MIN_WIDTH, Sizes.DEFAULT_MAX_HEIGHT * 3));
		
		addLayout(scrollList);
	}

	@Override
	public String getValue() {
		return label.getText() + list.getSelectedValue();
	}
}
