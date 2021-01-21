@Test public void shouldUseConfiguredDefaultHeaders(){
  final String etag="123";
  victim=new ResponseHeadersConfigurer(){
    @Override public void configureDefaultHeaders(    final Map<String,String> map){
      map.put(HttpHeader.ETAG.name(),etag);
    }
  }
;
  final Map<String,String> map=victim.getHeadersMap();
  assertEquals(1,map.size());
  assertEquals(etag,map.get(HttpHeader.ETAG.getHeaderName()));
}
