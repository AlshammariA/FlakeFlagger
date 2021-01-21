@Test public void removeNonMandatoryProperty() throws CommitFailedException {
  EffectiveType effective=createControl().createMock(EffectiveType.class);
  expect(effective.isMandatoryProperty("mandatory")).andReturn(false);
  replay(effective);
  TypeEditor editor=new TypeEditor(effective);
  editor.propertyDeleted(PropertyStates.createProperty("mandatory",""));
}
