/** 
 * When an empty resource is processed, the processing should not fail (warn only).
 */
@Test public void shouldNotFailWhenEmptyResourceIsFound() throws Exception {
  final WroConfiguration config=Context.get().getConfig();
  config.setIgnoreMissingResources(false);
  final UriLocator emptyStreamLocator=new UriLocator(){
    public boolean accept(    final String uri){
      return true;
    }
    public InputStream locate(    final String uri) throws IOException {
      return new ByteArrayInputStream("".getBytes());
    }
  }
;
  final UriLocatorFactory locatorFactory=new SimpleUriLocatorFactory().addLocator(emptyStreamLocator);
  final WroManagerFactory managerFactory=new BaseWroManagerFactory().setUriLocatorFactory(locatorFactory);
  InjectorBuilder.create(managerFactory).build().inject(victim);
  final List<Resource> resources=new ArrayList<Resource>();
  resources.add(Resource.create("/resource.js"));
  victim.processAndMerge(resources,true);
}
