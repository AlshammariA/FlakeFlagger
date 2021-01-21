@Test public void truthy() throws IOException {
  shouldCompileTo("{{#if value}}true{{else}}false{{/if}}",$("value","x"),"true");
  shouldCompileTo("{{#value}}true{{^}}false{{/value}}",$("value","x"),"true");
  shouldCompileTo("{{^value}}false{{/value}}",$("value","x"),"");
  shouldCompileTo("{{#if value}}true{{else}}false{{/if}}",$("value",$),"true");
  shouldCompileTo("{{#value}}true{{^}}false{{/value}}",$("value",$),"true");
  shouldCompileTo("{{^value}}false{{/value}}",$("value",$),"");
  shouldCompileTo("{{#if value}}true{{else}}false{{/if}}",$("value",true),"true");
  shouldCompileTo("{{#value}}true{{^}}false{{/value}}",$("value",true),"true");
  shouldCompileTo("{{^value}}false{{/value}}",$("value",true),"");
  shouldCompileTo("{{#if value}}true{{else}}false{{/if}}",$("value",asList("0")),"true");
  shouldCompileTo("{{#value}}true{{^}}false{{/value}}",$("value",asList("0")),"true");
  shouldCompileTo("{{^value}}false{{/value}}",$("value",asList(0)),"");
}
