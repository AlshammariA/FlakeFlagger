@Test public void spacesInBlock() throws IOException {
  shouldCompileTo("{{#if \"stuff\" }}Bingo{{/if}}",$,"Bingo");
  shouldCompileTo("{{#if \"stuff\"  }}Bingo{{/if}}",$,"Bingo");
  shouldCompileTo("{{#if \"stuff\"}}Bingo{{/if}}",$,"Bingo");
  shouldCompileTo("{{# if \"stuff\"}}Bingo{{/if}}",$,"Bingo");
  shouldCompileTo("{{#if \"stuff\"}}Bingo{{/ if}}",$,"Bingo");
  shouldCompileTo("{{# if \"stuff\" }}Bingo{{/ if }}",$,"Bingo");
}
