@Test public void shouldDetectGroupReferenceFromImportedModel(){
  final WroModel model=loadModelFromLocation("shouldDetectGroupReferenceFromImportedModel.xml");
  assertEquals(2,model.getGroups().size());
}
