package io.disc99.cinemacomplex.maintenance;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class CinemaPalaceEditor extends VerticalLayout {

	private final CinemaPalaceRepository repository;

	private CinemaPalace cinemaPalace;

	/* Fields to edit properties in Customer entity */
	TextField name = new TextField("name");
	TextField address = new TextField("address");

	/* Action buttons */
	Button save = new Button("Save", FontAwesome.SAVE);
	Button cancel = new Button("Cancel");
	Button delete = new Button("Delete", FontAwesome.TRASH_O);
	CssLayout actions = new CssLayout(save, cancel, delete);

	@Autowired
	public CinemaPalaceEditor(CinemaPalaceRepository repository) {
		this.repository = repository;

		addComponents(name, address, actions);

		// Configure and style components
		setSpacing(true);
		actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

		// wire action buttons to save, delete and reset
		save.addClickListener(e -> repository.save(cinemaPalace));
		delete.addClickListener(e -> repository.delete(cinemaPalace));
		cancel.addClickListener(e -> editCinemaPalace(cinemaPalace));
		setVisible(false);
	}

	public interface ChangeHandler {

		void onChange();
	}

	public final void editCinemaPalace(CinemaPalace c) {
		final boolean persisted = c.getId() != null;
		if (persisted) {
			// Find fresh entity for editing
			cinemaPalace = repository.findOne(c.getId());
		}
		else {
			cinemaPalace = c;
		}
		cancel.setVisible(persisted);

		// Bind cinemaPalace properties to similarly named fields
		// Could also use annotation or "manual binding" or programmatically
		// moving values from fields to entities before saving
		BeanFieldGroup.bindFieldsUnbuffered(cinemaPalace, this);

		setVisible(true);

		// A hack to ensure the whole form is visible
		save.focus();
		// Select all text in name field automatically
		name.selectAll();
	}

	public void setChangeHandler(ChangeHandler h) {
		// ChangeHandler is notified when either save or delete
		// is clicked
		save.addClickListener(e -> h.onChange());
		delete.addClickListener(e -> h.onChange());
	}

}
