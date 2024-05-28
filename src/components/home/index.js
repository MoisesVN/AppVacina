import { View, Text, TouchableOpacity, StyleSheet, Image } from "react-native";
import { useNavigation } from "@react-navigation/native";
import CarteiraHome from '../carteiraHome';
import styles from "./style"


export default function Carteira() {
    const navigation = useNavigation();
    return (

                <View style={styles.Tela}><CarteiraHome /></View>

    )
}