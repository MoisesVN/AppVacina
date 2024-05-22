import { StyleSheet } from "react-native";

const styles = StyleSheet.create({

    buttonAcessar:{
        marginLeft:180
    },
    Tela:{
        
    },
    title:{
      fontSize:20,
      paddingLeft:10,
      color: "dodgerblue"
    },
    Login: {
      fontSize:40,
      marginTop:180,
      color: "dodgerblue",
      marginBottom: "7%"
    },
    form:{
        marginTop:-80,
        flex:1,
        backgroundColor:'#ffffff',
        padding:10,
    },
    input:{
        borderWidth: 4,
        borderColor: "dodgerblue",
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
    marginTop:70,
    alignItems:'center',
    justifyContent:"space-between"
    },
    textButtonAcessar: {
        color: "dodgerblue",
        marginLeft: "31%"
    }

});

export default styles;