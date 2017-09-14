function tpl_strip(original,trim){res=original;for(var n=0;n<t.length;n++){res=res.replace(/\{\{(.*?)\}\}/g,function(trim,r){return trim[n][r]})}return res}

function onClientLoad() {
    gapi.client.load('youtube', 'v3', onYouTubeApiLoad);
}
function onYouTubeApiLoad() {
    gapi.client.setApiKey('AIzaSyBIeL29P9wc4xlLm2qwUFo4elqEy7-uOjM');
}
var responseString;
//var n;
function search() {
    var query = document.getElementById('txtSource').value;
    var request = gapi.client.youtube.search.list({
        part: 'snippet',
        q:query
    });
    request.execute(SearchResponse);
    //console.log(SearchResponse)
}
function SearchResponse(response) {
    var responseString = JSON.stringify(response,'',2);
    document.getElementById("response").innerHTML += responseString;
    $(each(results.items),function (index,item) {
        $("tpl/item.html",function (data) {
            $("results").append(tpl_strip(data, [{"title": item.snippet.title, "videoid": item.id.videoId}]))
        }
        //document.getElementById('response').innerHTML = n;
        //document.getElementById('response').innerHTML = responseString[item[videoId]];
        //document.getElementById('response').innerHTML = responseString.items.id;



