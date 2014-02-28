package net.shadowmage.ancientwarfare.structure.gui;

import net.shadowmage.ancientwarfare.core.container.ContainerBase;
import net.shadowmage.ancientwarfare.core.gui.GuiContainerBase;
import net.shadowmage.ancientwarfare.core.gui.Listener;
import net.shadowmage.ancientwarfare.core.gui.GuiContainerBase.ActivationEvent;
import net.shadowmage.ancientwarfare.core.gui.elements.Button;
import net.shadowmage.ancientwarfare.core.gui.elements.Checkbox;
import net.shadowmage.ancientwarfare.core.gui.elements.GuiElement;
import net.shadowmage.ancientwarfare.core.gui.elements.Label;
import net.shadowmage.ancientwarfare.core.gui.elements.Text;
import net.shadowmage.ancientwarfare.structure.template.build.validation.StructureValidationType;

public class GuiStructureScanner extends GuiContainerBase
{

private Text nameInput;
private Label validationTypeLabel;
private boolean includeOnExport = true;
private StructureValidationType validationType = StructureValidationType.GROUND;

public GuiStructureScanner(ContainerBase par1Container)
  {
  super(par1Container, 256, 240, defaultBackground);
  }

@Override
public void initElements()
  {
  Label label = new Label(8, 8, "Input Name:");
  this.addGuiElement(label);
  
  nameInput = new Text(8, 8+12, 160, "");
  this.addGuiElement(nameInput);
  
  Button button = new Button(256-55-8, 8, 55, 16, "Export");
  this.addGuiElement(button);
  
  button = new Button(256-55-8, 8+16, 55, 16, "Cancel");
  this.addGuiElement(button);
  
  int totalHeight = 36;
  
  Checkbox box = new Checkbox(8, totalHeight, 16, 16, "Include in game Immediately?");
  box.setChecked(true);
  box.addNewListener(new Listener(Listener.MOUSE_UP)
    {
    @Override
    public boolean onEvent(GuiElement widget, ActivationEvent evt)
      {
      includeOnExport = ((Checkbox)widget).checked(); 
      return true;
      }
    });
  this.addGuiElement(box);
  totalHeight+=16+8;
  
  validationTypeLabel = new Label(8, totalHeight, "Current validation type: "+validationType.getName()); 
  this.addGuiElement(validationTypeLabel);
  totalHeight+=10;
  
  button = new Button(8, totalHeight, 120, 16, "Setup Validation");
  this.addGuiElement(button);
  totalHeight+=16;
  
  button = new Button(8, totalHeight, 120, 16, "Select Biomes");
  this.addGuiElement(button);
  totalHeight+=16;
  
  button = new Button(8, totalHeight, 120, 16, "Select Targets");
  this.addGuiElement(button);
  totalHeight+=16;
  
  button = new Button(8, totalHeight, 120, 16, "Select Dimensions");
  this.addGuiElement(button);
  totalHeight+=16;
  
  }

@Override
public void setupElements()
  {
  validationTypeLabel.setText("Current validation type: "+validationType.getName());
  }

}
