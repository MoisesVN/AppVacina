import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
    
    formContext: {
        width:"100%",
        height:"100%",
        bottom:0,
        backgroundColor:"#C0C0C0",
        alignItems: "center",
        borderTopLeftRadius:30,
        borderTopRightRadius:30,
        marginTop:30,
    },
    form:{
        width:"100%",
        height:"auto",
        marginTop:30,
        padding:10
    },
    textButtonAcessar:{
        fontSize:22,
        color:"#FFFFFF"
    },
    buttonAcessar:{
        borderRadius:50,
        alignItems:"center",
        justifyContent:"center",
        width:"90%",
        backgroundColor:"#1E90FF",
        paddingTop:10,
        paddingBottom:10,
        marginLeft:12,
        margin:30
    },
    textTitle: {
        color: "#1C1C1C",
        fontSize: 36,
        fontWeight: "bold",
        paddingTop:100,
        marginLeft:20
    },
    
    Text: {
        marginTop: 30,
        marginLeft: 20,
        fontSize: 20,
    },
    botaoI: {
        color: "#FFFFFF"
    },
    telaP: {
        flex: 1,
        backgroundColor: 'red',
        display: "flex"
    },
    botao: {
        marginLeft: 20,
        marginTop: 40,
        backgroundColor: '#FFFFFF',
        borderRadius: 90,
    },
    Tela: {
        alignItems: 'flex-start',
    },
    botao2: {
        marginBottom: 20,
        borderRadius: 90,
        padding: 30,
        backgroundColor: '#392DE9'
    },
    Tela2: {
        position: "absolute",
        alignItems: 'center',
        backgroundColor: "red",
        marginTop: 490,
        marginLeft: 160
    }
    

});

export default styles;