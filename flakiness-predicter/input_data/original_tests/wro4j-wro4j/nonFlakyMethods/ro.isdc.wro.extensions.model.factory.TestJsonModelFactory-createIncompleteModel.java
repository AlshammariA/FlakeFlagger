/** 
 * Test the usecase when the resource has no type. For now, it is ok to have it null because you'll get a NPE exception during processing if no type is specified anyway.
 */
@Test public void createIncompleteModel(){
  factory=new JsonModelFactory(){
    @Override protected InputStream getModelResourceAsStream() throws IOException {
      return getClass().getResourceAsStream("incomplete-wro.json");
    }
  }
;
  final WroModel model=factory.create();
  Assert.assertNotNull(model);
  Assert.assertEquals(1,model.getGroups().size());
  final Group group=new ArrayList<Group>(model.getGroups()).get(0);
  Assert.assertNull(group.getResources().get(0).getType());
  LOG.debug("model: {}",model);
}
