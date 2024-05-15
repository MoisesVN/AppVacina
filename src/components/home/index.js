import { View,Text,TouchableOpacity,StyleSheet,Image} from "react-native";
import { useNavigation } from "@react-navigation/native";
import CarteiraHome from '../carteiraHome';


export default function Carteira(){
    const navigation = useNavigation();
    return(
    <View style={styles.telaP}>
      <View style={styles.Tela}> 
        <TouchableOpacity onPress={() => navigation.navigate("MenuConfig")} style={styles.botao}>
        <Image source={require("../imagens/kisspng-user-profile-computer-icons-profile-5ac0924526cda6.172054181522569797159 (1).png")}/>
    </TouchableOpacity>
    <View style={styles.Tela}><CarteiraHome/></View>
    </View>
      <View style={styles.Tela2}>
    <TouchableOpacity onPress={() => navigation.navigate("CarteiraCadastro")} style={styles.botao2}>
        <Image source={require("../imagens/kisspng-white-house-johns-hopkins-university-website-servi-white-cross-5ab020e49e7627.0961720415214921966491 (2).png")}
        />
    </TouchableOpacity></View>
    
    </View>

    )
}
const styles = StyleSheet.create({

  Text:{marginTop:30,
    marginLeft:20,
    fontSize: 20,
},
botaoI:{
    color:"#FFFFFF"
},
telaP:{
    flex:1,
    backgroundColor:'#1E90FF'
},
  botao:{
    marginLeft:20,
    marginTop:40,
    backgroundColor:'#FFFFFF',
    borderRadius:90,
},
Tela:{
    alignItems:'flex-start',
},
    botao2:{
        marginTop:250,
        borderRadius:90,
        padding:30,
        backgroundColor:'#392DE9'
    },
    Tela2:{
        alignItems:'center'
    }
});