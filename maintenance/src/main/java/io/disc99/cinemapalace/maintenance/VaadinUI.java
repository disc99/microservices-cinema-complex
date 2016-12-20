package io.disc99.cinemapalace.maintenance;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

@SpringUI
@Theme("valo")
public class VaadinUI extends UI {

    private final CinemaPalaceRepository repo;
    private final CinemaPalaceEditor editor;
    private final Grid grid;
    private final TextField filter;
    private final Button addNewBtn;

    @Autowired
    public VaadinUI(CinemaPalaceRepository repo, CinemaPalaceEditor editor) {
        this.repo = repo;
        this.editor = editor;
        this.grid = new Grid();
        this.filter = new TextField();
        this.addNewBtn = new Button("New Cinema Palace", FontAwesome.PLUS);
    }

    @Override
    protected void init(VaadinRequest request) {

        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
        setContent(mainLayout);

        actions.setSpacing(true);
        grid.setWidth(1000, Unit.PIXELS);
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);

        grid.setColumns("id", "name", "address");
        filter.setInputPrompt("Filter by name");

        filter.addTextChangeListener(e -> listCinemaPalaces(e.getText()));
        grid.addSelectionListener(e -> {
            if (e.getSelected().isEmpty()) {
                editor.setVisible(false);
            } else {
                editor.editCinemaPalace((CinemaPalace) grid.getSelectedRow());
            }
        });

        addNewBtn.addClickListener(e -> editor.editCinemaPalace(new CinemaPalace("", "")));
        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listCinemaPalaces(filter.getValue());
        });
        listCinemaPalaces(null);
    }

    private void listCinemaPalaces(String text) {
        List<CinemaPalace> cinemaPalaces = StringUtils.isEmpty(text) ? repo.findAll() : repo.findByNameStartsWithIgnoreCase(text);
        grid.setContainerDataSource(new BeanItemContainer<>(CinemaPalace.class, cinemaPalaces));
    }
}
