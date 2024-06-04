import { StyleSheet } from "react-native";

const styles = StyleSheet.create({

    botao2: {
        marginLeft: 170,
        marginTop: 100,
        padding: 10,
        backgroundColor: '#392DE9',
        borderRadius: 8,
    },
    Text2: {
        color: '#FFFFFF',
        fontSize: 20
    },

    Tela:{
        alignItems:'flex-start',
    },
    Tela1:{
        flex:1,
        backgroundColor:'#FFF'
    },
    Text:{marginTop:50,
        marginLeft:50,
        fontSize: 30,
        color: "dodgerblue"
    },
    Tela2:{
        marginTop:30
    },
    TelaUser:{

        margin: 12,
        marginLeft:35,
        marginTop:100,
        padding:140,
        justifyContent: 'center',
        height: 300, 
        paddingHorizontal: 10,
        backgroundColor:'#FFF',
        padding: 140,
        borderColor: 'dodgerblue', // Cor da borda
        borderWidth: 3,
        borderRadius:15 ,
        padding: 20,          // Preenchimento interno

    },
    TextUser:{
        margin: 10,
        fontSize: 25,

    },
});

export default styles;