@Test(expected=CommitFailedException.class) public void removeMandatoryProperty() throws CommitFailedException {
  EffectiveType effective=createControl().createMock(EffectiveType.class);
  expect(effective.isMandatoryProperty("mandatory")).andReturn(true);
  replay(effective);
  TypeEditor editor=new TypeEditor(effective);
  editor.propertyDeleted(PropertyStates.createProperty("mandatory",""));
}
