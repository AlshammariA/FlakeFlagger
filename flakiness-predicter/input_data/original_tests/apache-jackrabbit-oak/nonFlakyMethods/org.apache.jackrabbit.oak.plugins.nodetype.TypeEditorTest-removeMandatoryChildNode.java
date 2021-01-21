@Test(expected=CommitFailedException.class) public void removeMandatoryChildNode() throws CommitFailedException {
  EffectiveType effective=createControl().createMock(EffectiveType.class);
  expect(effective.isMandatoryChildNode("mandatory")).andReturn(true);
  replay(effective);
  TypeEditor editor=new TypeEditor(effective);
  editor.childNodeDeleted("mandatory",EMPTY_NODE);
}
