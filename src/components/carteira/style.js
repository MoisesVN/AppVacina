import { StyleSheet } from "react-native";

const styles = StyleSheet.create({

    botao: {
        marginLeft: 20,
        marginTop: 40,
        padding: 10,
        backgroundColor: '#392DE9',
        borderRadius: 8,
    },
    Tela: {
        alignItems: 'flex-start',
    },
    Tela1: {
        width: "100%",
        height: "100%",
        backgroundColor: "#FFFFFF",
    },

    Divdecima: {
        paddingLeft: 20,
        marginTop: 30,
        display: 'flex',
        flexDirection: 'row',
    },
    imgdePerfil: {
        marginLeft: 10,
        width: 140,
        height: 100,
        display: 'flex',
        justifyContent: 'center',
        backgroundColor: "#ECECEC",
        borderRadius: 18,
        alignItems: 'center'
    },
    nomeIdade: {
        justifyContent: 'center',
        padding: 10,
        backgroundColor: "#ECECEC",
        width: 220,
        height: 100,
        borderRadius: 18,
    },
    DivdoMeio: {

        margin: 10,
        padding: 10,
        justifyContent: 'center',
        borderRadius: 18,
        marginLeft: 20,
        width: 370,
        height: 100,
        backgroundColor: '#392DE9'

    },
    textMeio: {
        color: 'white'
    },
    DivdeBaixo: {
        backgroundColor: "#ECECEC",
        width: 370,
        height: 140,
        margin: 10,
        marginLeft: 20,
        borderRadius: 18,
        padding: 10,
    },

    divconteiner: {
        display: 'flex',
        alignItems: 'center',

    },
    vacinas: {
        //flex: 1
    },
    container: {
        //flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
      },
    image: {
        borderRadius: 18,
        width: "100%",
        height: "100%",
        resizeMode: 'cover', // ou 'cover', 'stretch', etc., conforme necessário
    },
    textError:{
        paddingLeft: 90,
        paddingTop: 30,
        fontSize: 20
    }
});

export default styles;