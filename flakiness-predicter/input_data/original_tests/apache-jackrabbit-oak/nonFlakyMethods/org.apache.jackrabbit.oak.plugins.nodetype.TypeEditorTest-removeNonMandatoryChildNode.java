@Test public void removeNonMandatoryChildNode() throws CommitFailedException {
  EffectiveType effective=createControl().createMock(EffectiveType.class);
  expect(effective.isMandatoryChildNode("mandatory")).andReturn(false);
  replay(effective);
  TypeEditor editor=new TypeEditor(effective);
  editor.childNodeDeleted("mandatory",EMPTY_NODE);
}
