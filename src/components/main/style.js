import { StyleSheet } from "react-native";

const styles = StyleSheet.create({

    buttonAcessar:{
        marginLeft:180
    },
    Tela:{
        marginTop:50
    },
    title:{
      fontSize:17,
      paddingLeft:10,
    },
    Login: {
      fontSize:30,
      marginTop:180,
    },
    form:{
        marginTop:-80,
        flex:1,
        backgroundColor:'#1E90FF',
        padding:10,
    },
    input:{
        borderRadius:10,
        backgroundColor:"#DCDCDC",
        height:60,
        margin:12,
        paddingLeft:10,
    },
    textButtonClean:{
        fontSize:22,
        color:"#FFFFFF"
    },
    botao:{
        backgroundColor:"#FFFFFF",
        borderRadius:8,
        marginLeft:25,
        flex:1,
        alignItems:'center',
        marginTop:10,
        padding:6,
    },
    botaoS:{
        fontSize:22,
        color:"#253BFF",
        borderColor:'#392DE9',
    },
    botaoSalvar:{
    backgroundColor:"#392DE9",
    borderRadius:8,
    },
    botaoArea:{
    flexDirection:"row",
    width:'90%',
    marginTop:130,
    alignItems:'center',
    justifyContent:"space-between"
    },

});

export default styles;