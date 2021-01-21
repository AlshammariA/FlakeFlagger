@Test public void shouldBeThreadSafeWhenMutated() throws Exception {
  final Group group=new Group("group");
  final List<Resource> resources=new ArrayList<Resource>();
  final Resource r1=Resource.create("/some.css",ResourceType.CSS);
  resources.add(r1);
  WroTestUtils.runConcurrently(new Callable<Void>(){
    public Void call() throws Exception {
      if (new Random().nextBoolean()) {
        group.setResources(resources);
      }
 else {
        group.addResource(r1);
        group.replace(r1,resources);
      }
      return null;
    }
  }
);
}
